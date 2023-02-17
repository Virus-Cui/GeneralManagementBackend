package cn.mrcsh.Task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleTask implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        new Thread(()->{
            Scanner input = new Scanner(System.in);
            while (true) {
                switch (input.nextLine()) {
                    case "stop":
                    case "end":
                    case "quit":
                        log.warn("服务器关闭中。。。");
                        input.close();
                        System.exit(0);
                        break;
                    default:
                        log.error("未知指令");
                        break;
                }
            }
        }).start();
    }
}
