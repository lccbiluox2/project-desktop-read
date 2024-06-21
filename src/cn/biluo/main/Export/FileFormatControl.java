package cn.biluo.main.Export;

public class FileFormatControl {
	
	/**
	 * @param next ****************************************************/
	//把文件写入不同格式的输出
	public void fileFormatControl(String next){
		String[] nexts = next.split("##");
		
		SaveByFormat sav = new SaveByFormat();
		
		for (int i = 0; i < nexts.length; i++) {
			if(nexts[i].equals("导出为txt格式")){
				sav.saveToText(next);
			}else if(nexts[i].equals("导出为word格式")){
				sav.saveToText(next);
			}else if(nexts[i].equals("导出为压缩格式")){
				sav.saveToCompress(next);
			}
		}
		
	}
	/******************************************************/
	
	
	
}
