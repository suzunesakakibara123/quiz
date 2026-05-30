package com.example.demo.quiz.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.quiz.entity.Quiz2;
import com.example.demo.quiz.form.Quiz10Form;
import com.example.demo.quiz.form.Quiz2AnswerForm;
import com.example.demo.quiz.form.Quiz2Form;
import com.example.demo.quiz.service.Quiz2Service;

/** Quizコントローラ */
@Controller
@RequestMapping("/quiz2")
public class Quiz2Controller {

    /** DI対象 */
    @Autowired
    Quiz2Service service;

    /** 「form-backing bean」の初期化 */
    @ModelAttribute
    public Quiz2Form setUpForm() {

        Quiz2Form form = new Quiz2Form();

        // ラジオボタンのデフォルト値設定
        form.setAnswer(true);

        return form;
    }

    /** Quizの一覧を表示します */
    @GetMapping
    public String showList(Quiz2Form quiz2Form, Model model) {

        // 新規登録設定
        quiz2Form.setNewQuiz(true);

        // クイズの一覧を取得する
        Iterable<Quiz2> list = service.selectAllQuiz2();

        // 表示用「Model」への格納
        model.addAttribute("list", list);
        model.addAttribute("title", "登録用フォーム");

        return "quiz2/crud2";
    }

    /** Quizデータを1件挿入 */
    @PostMapping("/insert")
    public String insert(
            @Validated Quiz2Form quiz2Form,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {

        // FormからEntityへの詰め替え
        Quiz2 quiz2 = new Quiz2();

        quiz2.setQuestion(quiz2Form.getQuestion());
        quiz2.setAnswer(quiz2Form.getAnswer());
        quiz2.setAuthor(quiz2Form.getAuthor());

        // 入力チェック
        if (!bindingResult.hasErrors()) {

            service.insertQuiz(quiz2);

            redirectAttributes.addFlashAttribute(
                    "complete",
                    "登録が完了しました");

            return "redirect:/quiz2";

        } else {

            // エラーがある場合は、一覧表示処理を呼びます
            return showList(quiz2Form, model);
        }
    }

    /** Quizデータを1件取得し、フォーム内に表示する */
    @GetMapping("/{id:[0-9]+}")
    public String showUpdate(
            Quiz2Form quiz2Form,
            @PathVariable Integer id,
            Model model) {

        // Quizを取得(Optionalでラップ)
        Optional<Quiz2> quizOpt = service.selectOneById(id);

        // Quiz2Formへの詰め直し
        Optional<Quiz2Form> quiz2FormOpt =
                quizOpt.map(t -> makeQuiz2Form(t));

        // Quiz2Formがnullでなければ中身を取り出す
        if (quiz2FormOpt.isPresent()) {
            quiz2Form = quiz2FormOpt.get();
        }

        // 更新用のModelを作成する
        makeUpdateModel(quiz2Form, model);

        return "quiz2/crud2";
    }

    /** 更新用のModelを作成する */
    private void makeUpdateModel(
            Quiz2Form quiz2Form,
            Model model) {

        model.addAttribute("id", quiz2Form.getId());

        quiz2Form.setNewQuiz(false);

        model.addAttribute("quiz2Form", quiz2Form);

        model.addAttribute("title", "更新用フォーム");
    }

    /** idをKeyにしてデータを更新する */
    @PostMapping("/update")
    public String update(
            @Validated Quiz2Form quiz2Form,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {

        // Quiz2FormからQuizに詰め直す
        Quiz2 quiz2 = makeQuiz(quiz2Form);

        // 入力チェック
        if (!result.hasErrors()) {

            // 更新処理、フラッシュスコープの使用、リダイレクト
            service.updateQuiz(quiz2);

            redirectAttributes.addFlashAttribute(
                    "complete",
                    "更新が完了しました");

            // 更新画面を表示する
            return "redirect:/quiz2/" + quiz2.getId();

        } else {

            // 更新用のModelを作成する
            makeUpdateModel(quiz2Form, model);

            return "quiz2/crud2";
        }
    }

    /* ---------- 以下はFormとDomainObjectの詰めなおし ---------- */

    /** Quiz2FormからQuizに詰め直して戻り値として返します */
    private Quiz2 makeQuiz(Quiz2Form quiz2Form) {

        Quiz2 quiz2 = new Quiz2();

        quiz2.setId(quiz2Form.getId());
        quiz2.setQuestion(quiz2Form.getQuestion());
        quiz2.setAnswer(quiz2Form.getAnswer());
        quiz2.setAuthor(quiz2Form.getAuthor());

        return quiz2;
    }

    /** QuizからQuiz2Formに詰め直して戻り値として返します */
    private Quiz2Form makeQuiz2Form(Quiz2 quiz2) {

        Quiz2Form form = new Quiz2Form();

        form.setId(quiz2.getId());
        form.setQuestion(quiz2.getQuestion());
        form.setAnswer(quiz2.getAnswer());
        form.setAuthor(quiz2.getAuthor());

        form.setNewQuiz(false);

        return form;
    }

    /** idをKeyにしてデータを削除する */
    @PostMapping("/delete")
    public String delete(
            @RequestParam("id") String id,
            Model model,
            RedirectAttributes redirectAttributes) {

        // クイズを1件削除してリダイレクト
        service.deleteQuizById(Integer.parseInt(id));

        redirectAttributes.addFlashAttribute(
                "delcomplete",
                "削除が完了しました");

        return "redirect:/quiz2";
    }

    /* ---------- 以下はクイズで遊ぶ機能 ---------- */

    /** Quizデータをランダムで1件取得し、画面に表示する */
    @GetMapping("/play2")
    public String showQuiz(Quiz2Form quiz2Form, Model model) {

        // Quizを取得(Optionalでラップ)
        Optional<Quiz2> quizOpt = service.selectOneRandomQuiz2();

        // 値が入っているか判定する
        if (quizOpt.isPresent()) {

            // Quiz2Formへの詰め直し
            Optional<Quiz2Form> quiz2FormOpt =
                    quizOpt.map(t -> makeQuiz2Form(t));

            quiz2Form = quiz2FormOpt.get();

        } else {

            model.addAttribute("msg", "問題がありません・・・");

            return "quiz2/play2";
        }

        // 表示用「Model」への格納
        model.addAttribute("quiz2Form", quiz2Form);

        return "quiz2/play2";
    }
    /** 1問クイズの正解・不正解を判定する */
    @PostMapping("/check2")
    public String checkQuiz2(
            Quiz2Form quiz2Form,
            @RequestParam Boolean answer,
            Model model) {

        // 正解・不正解を判定する
        boolean result = service.checkQuiz(
                quiz2Form.getId(),
                answer);

        if (result) {
            model.addAttribute("msg", "正解です！");
        } else {
            model.addAttribute("msg", "不正解です・・・");
        }

        return "quiz2/result2";
    }

    /** Quizデータをランダムで10件取得し、画面に表示する */
    @GetMapping("/play10")
    public String showQuiz10(Model model) {

        // Serviceからランダムに10問取得し、複数件扱える型のquizListに入れる
        Iterable<Quiz2> quizList = service.findRandom10Quiz2();

        // 取得した10問のクイズをHTMLに渡す
        model.addAttribute("quizList", quizList);

        // 10問回答用のFormをHTMLに渡す
        model.addAttribute("quiz10Form", new Quiz10Form());

        // play10.htmlを表示させる
        return "quiz2/play10";
    }

    /** 10問回答の正解数を判定する */
    @PostMapping("/check10")
    public String checkQuiz10(
            Quiz10Form quiz10Form,
            Model model) {

        int correctCount = 0;
        int answerCount = 0;

        for (Quiz2AnswerForm answer : quiz10Form.getAnswers()) {

            if (answer.getId() == null) {
                continue;
            }

            if (answer.getMyAnswer() == null) {
                continue;
            }

            answerCount++;

            boolean result = service.checkQuiz(
                    answer.getId(),
                    answer.getMyAnswer());

            answer.setCorrect(result);

            if (result) {
                correctCount++;
            }
        }

        model.addAttribute("correctCount", correctCount);
        model.addAttribute("totalCount", answerCount);
        model.addAttribute("answers", quiz10Form.getAnswers());

        return "quiz2/result10";
    }
    
    /** 2択問題CSVアップロード画面を表示する */
    @GetMapping("/csv-upload")
    public String showCsvUpload2() {
        return "quiz2/csvUpload2";
    }

    /** 2択問題CSVを読み込んで登録する */
    @PostMapping("/csv-upload")
    public String uploadCsv2(
            @RequestParam("file") MultipartFile file,
            Model model) {

        if (file.isEmpty()) {
            model.addAttribute("error", "CSVファイルを選択してください。");
            return "quiz2/csvUpload2";
        }

        int count = 0;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {

            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");

                if (data.length < 3) {
                    continue;
                }

                Quiz2 quiz2 = new Quiz2();

                quiz2.setQuestion(data[0]);
                quiz2.setAnswer(Boolean.parseBoolean(data[1]));
                quiz2.setAuthor(data[2]);

                service.insertQuiz(quiz2);

                count++;
            }

        } catch (Exception e) {
            model.addAttribute("error", "CSV登録中にエラーが発生しました。");
            return "quiz2/csvUpload2";
        }

        model.addAttribute("msg", count + "件の2択問題を登録しました。");

        return "quiz2/csvUpload2";
    }
}