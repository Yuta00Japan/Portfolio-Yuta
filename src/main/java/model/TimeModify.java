package model;

/**
 * @author yuta
 *input type dateに付属するーを除去するロジック
 */
public class TimeModify {
  
	public String remove(String time){
		
		time = time.replaceAll("[-]", "");
		
		return time;
	}
	
}
