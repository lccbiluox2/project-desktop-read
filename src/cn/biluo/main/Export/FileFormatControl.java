package cn.biluo.main.Export;

public class FileFormatControl {
	
	/**
	 * @param next ****************************************************/
	//���ļ�д�벻ͬ��ʽ�����
	public void fileFormatControl(String next){
		String[] nexts = next.split("##");
		
		SaveByFormat sav = new SaveByFormat();
		
		for (int i = 0; i < nexts.length; i++) {
			if(nexts[i].equals("����Ϊtxt��ʽ")){
				sav.saveToText(next);
			}else if(nexts[i].equals("����Ϊword��ʽ")){
				sav.saveToText(next);
			}else if(nexts[i].equals("����Ϊѹ����ʽ")){
				sav.saveToCompress(next);
			}
		}
		
	}
	/******************************************************/
	
	
	
}
