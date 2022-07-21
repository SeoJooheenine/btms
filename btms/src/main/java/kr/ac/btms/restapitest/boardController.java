package kr.ac.btms.restapitest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apitest/boards")
public class boardController {
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<ArticleVO>> listArticles(){
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		for(int i = 0; i<10; i++) {
			ArticleVO vo = new ArticleVO();
			vo.setArticleNO(i);
			vo.setWriter("이순신"+i);
			vo.setTitle("안녕하세요"+i);
			vo.setContent("새 상품 소개!!"+i);
			list.add(vo);
		}
		return new ResponseEntity<List<ArticleVO>>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{articleNO}", method = RequestMethod.GET)
	public ResponseEntity<ArticleVO> findArticle(@PathVariable("articleNO") Integer articleNO ){
		ArticleVO vo  = new ArticleVO();
		vo.setArticleNO(articleNO);
		vo.setWriter("홍길동");
		vo.setTitle("안녕하세요");
		vo.setContent("홍길동입니ㅏㄷ1");
		return new ResponseEntity<ArticleVO>(vo,HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> addArticle(@RequestBody ArticleVO articleVO){
		ResponseEntity<String> resEntity  = null;
		try {
			resEntity = new ResponseEntity<String>("ADD_SUCCEEDED", HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	return resEntity;
	}
	
	@RequestMapping(value = "/{articleNO}", method = RequestMethod.PUT)
	public ResponseEntity<String> modArticle(@PathVariable("articleNO") Integer articleNO, @RequestBody ArticleVO articleVO){
		ResponseEntity<String> resEntity = null;
		try {
			resEntity = new ResponseEntity<String>("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
	
	@RequestMapping(value= "/{articleNO}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeArticle(@PathVariable("articleNO") Integer articleNO){
		ResponseEntity<String> resEntity = null;
		try {
			resEntity = new ResponseEntity<String>("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
}
