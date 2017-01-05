package cn.mhope.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File("D:\\tools\\temp\\TestStudent.java"));
			byte[] b = new byte[1024];
			int len = 0;
			while ((len=fis.read(b))>=0) {
				System.out.write(b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (fis!=null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
