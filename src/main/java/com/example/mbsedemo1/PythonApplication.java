package com.example.mbsedemo1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonApplication {
    public static void main(String[] args) {
        // python环境的绝对路径
        String envPath = "/opt/anaconda3/envs/transformers";
        // python脚本的绝对路径，在windows中用"\\"分隔，在Linux中用"/"分隔
//        String pyPath = "E:\\testDemo\\src\\resource\\modelDemo3.py";
        String pyPath = "src/main/resources/LLMmodel/model_test.py";
        String text_1 = "The DPU-CCM shall forward CLK_MSGs to the DPU-TIS for processing immediately upon receipt (I.e. shall not enqueue the message to the command dispatcher queue).";
        String text_2 = "Startup SequenceThe DPU FSW is booted using PROM-resident bootstrap software.  The bootstrap software performs a basic set of built-in tests, then copies the DPU FSW from EEPROM to DRAM and executes it.  In flight, there are two methods which can trigger the DPU FSW to boot:* power-on (cold boot), or* watchdog reset (warm boot, commanded reboot).";
        String[] args1 = new String[]{envPath, pyPath, text_1 , text_2};
//        String[] args1 = new String[]{envPath, pyPath, "123", "456"};
        try {
            // 执行Python文件，并传入参数
            Process process = Runtime.getRuntime().exec(args1);
            // 获取Python输出字符串作为输入流被Java读取
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            in.close();
            process.waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}