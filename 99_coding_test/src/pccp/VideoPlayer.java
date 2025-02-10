package pccp;

public class VideoPlayer {
  public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
    // 초단위로 변경
  	int videoLenToSec = convertToSec(video_len);
  	int posToSec = convertToSec(pos);
  	int startToSec = convertToSec(op_start);
  	int endToSec = convertToSec(op_end);
    
  	posToSec = openingSkip(posToSec, startToSec, endToSec);
  	for(String command : commands) {
  		if(command.equals("next")) {
  			posToSec = posToSec + 10 >= videoLenToSec ? videoLenToSec : posToSec + 10; 
  		}else {
  			posToSec = posToSec - 10 <= 0 ? 0 : posToSec-10;
  		}
  		posToSec = openingSkip(posToSec, startToSec, endToSec);
  	}
  	// 분단위로 변경
  	int min = posToSec/60;
  	int sec = posToSec%60;

		return String.format("%02d:%02d",min,sec);
	}
  // 초단위로 변환
  public int convertToSec(String time) { 	
  	String[] arr = time.split(":");
  	return Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]);
  }
  // 오프닝 스킵
  public int openingSkip(int pos, int start, int end) {
  	return pos >= start && pos < end ?  end :  pos;
  }
}
