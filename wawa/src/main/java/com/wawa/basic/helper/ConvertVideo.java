package com.wawa.basic.helper;

import java.util.List;

/**
 * 转换视频格式
 * 
 * @author: Yang Xiaodong
 * @since: 2014年4月17日 上午9:53:33
 * @history:
 */
public class ConvertVideo {
	// c:\program files\ffmpeg\bin\ffmpeg.exe" -i %1 -b 1500k -vcodec libx264
	// -vpre slow -vpre baseline -g 30 -s 640x360 %1.mp4
	// REM webm (VP8 / Vorbis)
	// "c:\program files\ffmpeg\bin\ffmpeg.exe" -i %1 -b 1500k -vcodec libvpx
	// -acodec libvorbis -ab 160000 -f webm -g 30 -s 640x360 %1.webm
	// REM ogv (Theora / Vorbis)
	// "c:\program files\ffmpeg\bin\ffmpeg.exe" -i %1 -b 1500k -vcodec libtheora
	// -acodec libvorbis -ab 160000 -g 30 -s 640x360 %1.ogv
	// REM jpeg (screenshot at 10 seconds)
	// "c:\program files\ffmpeg\bin\ffmpeg.exe" -i %1 -ss 00:10 -vframes 1 -r 1
	// -s 640x360 -f image2 %1.jpg
	// I save this as a batch file and then just drag and drop videos on it to
	// get everything ready for HTML5.

	public static int checkContentType(String path) {
		String type = path.substring(path.lastIndexOf(".") + 1, path.length())
				.toLowerCase();
		// ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
		if (type.equals("avi")) {
			return 1;
		} else if (type.equals("mpg")) {
			return 1;
		} else if (type.equals("wmv")) {
			return 1;
		} else if (type.equals("3gp")) {
			return 1;
		} else if (type.equals("mov")) {
			return 1;
		} else if (type.equals("mp4")) {
			return 1;
		} else if (type.equals("asf")) {
			return 1;
		} else if (type.equals("asx")) {
			return 1;
		} else if (type.equals("flv")) {
			return 1;
		}
		// 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
		// 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
		else {
			return 0;
		}
	}

	// ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
	public static String processOGG(String oldFileName,String appPath) {
		appPath = "D:/git/wawa/wawa/target/wawa/";
		if (checkContentType(oldFileName) != 1) {
			return "";
		}
		String newFileName = oldFileName.substring(0,
				oldFileName.lastIndexOf(".") + 1)
				+ "ogg";
		List<String> commend = new java.util.ArrayList<String>();
		commend.add("D:\\ffmpeg\\bin\\ffmpeg.exe");
		commend.add("-i");
		commend.add(appPath+oldFileName);
		commend.add("-b");
		commend.add("1500k");
		commend.add("-vcodec");
		commend.add("libtheora");
		commend.add("-g");
		commend.add("30");
		commend.add("-s");
		commend.add("640x360");
		commend.add(appPath+newFileName);
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			builder.start();
			return newFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}