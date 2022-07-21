package kr.ac.btms.restapitest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test/*")
public class apiController {
	static Logger logger = Logger.getLogger(apiController.class.getName());
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hi REST";
	}
	
	@RequestMapping("/hiapi")
	public apiVO hiApi() {
		apiVO vo = new apiVO();
		vo.setId("hong");
		vo.setPwd("1234");
		vo.setName("홍길동");
		vo.setEmail("hong@api.com");
		
		return vo;
	}
	
	@RequestMapping("/apiList")
	public List<apiVO> listApi(){
		List<apiVO> list = new ArrayList<apiVO>();
		for(int i =0; i<10;i++) {
			apiVO vo = new apiVO();
			vo.setId("hong"+i);
			vo.setPwd("1234"+i);
			vo.setName("홍길동"+i);
			vo.setEmail("hong"+i+"@api.com");
			list.add(vo);
		}
		return list;
	}
	
	@RequestMapping("/apiMap")
	public Map<Integer, apiVO> mapApi(){
		Map<Integer, apiVO> map = new HashMap<Integer, apiVO>();
		for(int i =0; i<10;i++) {
			apiVO vo = new apiVO();
			vo.setId("hong"+i);
			vo.setPwd("1234"+i);
			vo.setName("홍길동"+i);
			vo.setEmail("hong"+i+"@api.com");
			map.put(i,vo);
		}
		return map;
	}
	
	@RequestMapping(value = "/api/{num}",method = RequestMethod.GET)
	public int notice(@PathVariable("num") int num) throws Exception{
		return num;
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public void modify(@RequestBody apiVO vo) {
		logger.info(vo.toString());
	}
	
	@RequestMapping("/memberList")
	public ResponseEntity<List<apiVO>> listMember(){
		List<apiVO> list = new ArrayList<apiVO>();
		for (int i =0; i<10;i++) {
			apiVO vo = new apiVO();
			vo.setId("hong"+i);
			vo.setPwd("1234"+i);
			vo.setName("홍길동"+i);
			vo.setEmail("hong"+i+"@api.com");
			list.add(vo);
		}
		return new ResponseEntity<List<apiVO>>(list,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value="/res3")
	public ResponseEntity<String> res3() {
		HttpHeaders responsHeaders =new HttpHeaders();
		responsHeaders.add("Content-Type", "text/html; charset=utf-8");
		String message = "<script>";
		message += "alert('새 회원을 등록합니다.')";
		message += "location.href='/btms/test/memberList';";
		message += "</script>";
		
		return new ResponseEntity<String>(message, responsHeaders, HttpStatus.CREATED);
	}
	
	}
