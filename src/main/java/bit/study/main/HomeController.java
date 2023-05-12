package bit.study.main;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(HttpServletRequest request) 
	{
		delete(request);	// webapp에 쌓인 mp3 파일 및 얼굴 인식 이미지들을 모두 지운다
		return "home";
	}
	
	public void delete(HttpServletRequest request)
	{
		String uploadPath=request.getSession().getServletContext().getRealPath("/");

		File files=new File(uploadPath+"/");
		String []list=files.list();
		//System.out.println(list.length);
		for(String fn:list)
		{
			System.out.println(fn);
			File f=new File(uploadPath+"/"+fn);
			//if(fn.endsWith("mp3"))
			//{
				if(f.exists()) {
					System.out.println(fn+" 파일 삭제");
					f.delete();
				}
			//}			
		}
	}

}
