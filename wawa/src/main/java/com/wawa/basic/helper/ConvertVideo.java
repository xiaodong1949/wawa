package com.wawa.basic.helper;

import java.io.File;
import java.util.List;

/** 
 * 转换视频格式
 * @author: Yang Xiaodong
 * @since: 2014年4月17日 上午9:53:33 
 * @history:
 */
public class ConvertVideo {
//    c:\program files\ffmpeg\bin\ffmpeg.exe" -i %1 -b 1500k -vcodec libx264 -vpre slow -vpre baseline                                            -g 30 -s 640x360 %1.mp4
//    REM webm (VP8 / Vorbis)
//    "c:\program files\ffmpeg\bin\ffmpeg.exe" -i %1 -b 1500k -vcodec libvpx                              -acodec libvorbis -ab 160000 -f webm    -g 30 -s 640x360 %1.webm
//    REM ogv  (Theora / Vorbis)
//    "c:\program files\ffmpeg\bin\ffmpeg.exe" -i %1 -b 1500k -vcodec libtheora                           -acodec libvorbis -ab 160000            -g 30 -s 640x360 %1.ogv
//    REM jpeg (screenshot at 10 seconds)
//    "c:\program files\ffmpeg\bin\ffmpeg.exe" -i %1 -ss 00:10 -vframes 1 -r 1 -s 640x360 -f image2 %1.jpg
//    I save this as a batch file and then just drag and drop videos on it to get everything ready for HTML5.
    private final static String PATH = "e:/IMG_0091.MOV";
    public static void main(String[] args) {
           if(!checkfile(PATH)){
            System.out.println(PATH+" is not file");
            return;
           }       
     if (process()) {                 
               System.out.println("ok");
           }
    }
    
    private static boolean process() {       
     int type = checkContentType();
           boolean status = false;
           if (type==0) {
               status = processFLV(PATH);// 直接将文件转为flv文件           
           } else if (type==1) {
               String avifilepath = processAVI(type);
               if (avifilepath == null)
                   return false;// avi文件没有得到
               status = processFLV(avifilepath);// 将avi转为flv
           }
           return status;
       }
       private static int checkContentType() {
           String type = PATH.substring(PATH.lastIndexOf(".") + 1,
             PATH.length()).toLowerCase();
   //ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
           if (type.equals("avi")) {
               return 0;
           } else if (type.equals("mpg")) {
               return 0;
           } else if (type.equals("wmv")) {
               return 0;
           } else if (type.equals("3gp")) {
               return 0;
           } else if (type.equals("mov")) {
               return 0;
           } else if (type.equals("mp4")) {
               return 0;
           } else if (type.equals("asf")) {
               return 0;
           } else if (type.equals("asx")) {
               return 0;
           } else if (type.equals("flv")) {
               return 0;
           }
           //对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
           else if (type.equals("wmv9")) {
               return 1;
           } else if (type.equals("rm")) {
               return 1;
           } else if (type.equals("rmvb")) {
               return 1;
           }       
           return 9;
       }
      
       private static boolean checkfile(String path){
        File file=new File(path);
        if(!file.isFile()){
         return false;
        }
        return true;
       }
   //  对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
       private static String processAVI(int type) {
           List<String> commend=new java.util.ArrayList<String>();
           commend.add("e:\\mencoder");
           commend.add(PATH);
           commend.add("-oac");
           commend.add("lavc");
           commend.add("-lavcopts");
           commend.add("acodec=mp3:abitrate=64");
           commend.add("-ovc");
           commend.add("xvid");
           commend.add("-xvidencopts");
           commend.add("bitrate=600");
           commend.add("-of");
           commend.add("avi");
           commend.add("-o");
           commend.add("c:\\home\\a.avi");
          
           try{
            ProcessBuilder builder = new ProcessBuilder();
               builder.command(commend);
               builder.start();
               return "c:\\home\\a.avi";
           }catch(Exception e){
            e.printStackTrace();
            return null;
           }
       }
   //  ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
       private static boolean processFLV(String oldfilepath) {
        
         if(!checkfile(PATH)){
             System.out.println(oldfilepath+" is not file");
             return false;
            }     
          
           List<String> commend=new java.util.ArrayList<String>();
           commend.add("D:\\ffmpeg\\bin\\ffmpeg.exe");
           commend.add("-i");
           commend.add(oldfilepath);

           commend.add("-b");
           commend.add("1500k");
           commend.add("-vcodec");
           commend.add("libtheora");
           commend.add("-g");
           commend.add("30");
           commend.add("-s");
           commend.add("640x360");
           commend.add("C:\\a.ogg");
           try {
               ProcessBuilder builder = new ProcessBuilder();
               builder.command(commend);
               builder.start();
               return true;
           } catch (Exception e) {
               e.printStackTrace();
               return false;
           }
       }
    
   }