package com.example.demo.quiz;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.quiz.entity.Quiz;
import com.example.demo.quiz.repository.QuizRepository;
import com.example.demo.quiz.service.QuizService;

@SpringBootApplication
public class QuizApplication {
    /**起動メソッド*/
	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args)
		.getBean(QuizApplication.class).execute();
	}
	/**注入*/
  	@Autowired
  	QuizService service;
  	@Autowired
  	QuizRepository repository;
  	/**実行メソッド*/
  	public void execute() {
  		//登録処理
  		//setup();
  		//全件取得
  		//showList();
  		//1件取得
  		//showOne();
  		//更新処理
  		//updateQuiz();
  		//削除処理
  		//deleteQuiz();
  		//クイズを実行する
  	    doQuiz();
  	}
  	/**登録処理*/
  	public void setup() {
  		//エンティティ生成
  		Quiz quiz1 = new Quiz(null, "Javaはオブジェクト指向言語である。", true, "山田太郎");
  		//登録実行
  		quiz1 = repository.save(quiz1);
  		//エンティティの内容を確認
  		System.out.println("登録したデータ："+quiz1);
  		//エンティティ生成2
  		Quiz quiz2 = new Quiz(null, "Javaは関数型言語である。", false, "山田太郎");
  		//登録実行
  		quiz1 = repository.save(quiz2);
  		//エンティティの内容を確認
  		System.out.println("登録したデータ："+quiz2);
  	}
  	
  	/**==全件取得==*/
  	private void showList() {
  		System.out.println("全件取得");
  		//リポジトリを使用して全件取得を実施、結果を取得
  		Iterable<Quiz> quizzes = repository.findAll();
  		for(Quiz quiz : quizzes) {
  			System.out.println(quiz);
  			System.out.println(quiz);
  		}
  		System.out.println("全件取得終了");
  	}
  	
  	/**1件取得*/
  	private void showOne() {
  		System.out.println("1件取得");
  		//リポジトリを使用して1件取得を実施、結果を取得
  		Optional<Quiz> quizOpt = repository.findById(1);
  		//値存在チェック
  		if(quizOpt.isPresent()) {
  			System.out.println(quizOpt.get());
  		}else {
  			System.out.println("データが存在しません");
  		}
  		System.out.println("1件取得終了");
  	}
  	
  	/*更新処理*/
  	private void updateQuiz() {
  		System.out.println("更新処理");
  		//変更したいエンティティを生成する
  		Quiz quiz1 = new Quiz(1, "Javaはオブジェクト指向言語である。", true, "変更太郎");
  		//更新実行
  		quiz1 = repository.save(quiz1);
  		System.out.println("更新したデータ："+quiz1);
  		System.out.println("更新処理終了");
  	}
  	
  	/**削除処理*/
  	private void deleteQuiz() {
  		System.out.println("削除処理");
  		//削除実行
  		repository.deleteById(2);
  		repository.deleteById(3);
  		repository.deleteById(4);
  		repository.deleteById(5);
  		repository.deleteById(6);
  		repository.deleteById(7);
  		System.out.println("削除処理終了");
  	}
  	/** === ランダムでクイズを取得して、クイズの正解/不正解を判定する === */
  	private void doQuiz() {

  	    System.out.println("--- クイズ1件取得開始 ---");

  	    // リポジトリを使用して1件取得を実施、結果を取得（戻り値はOptional）
  	    Optional<Quiz> quizOpt = service.selectOneRandomQuiz();

  	    // 値存在チェック
  	    if (quizOpt.isPresent()) {
  	        System.out.println(quizOpt.get());
  	    } else {
  	        System.out.println("該当する問題が存在しません・・・");
  	    }

  	    System.out.println("--- クイズ1件取得完了 ---");

  	    // 解答を実施
  	    Boolean myAnswer = false;

  	    Integer id = quizOpt.get().getId();

  	    if (service.checkQuiz(id, myAnswer)) {
  	        System.out.println("正解です！");
  	    } else {
  	        System.out.println("不正解です・・・");
  	    }
  	}
}
