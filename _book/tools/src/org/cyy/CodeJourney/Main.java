package org.cyy.CodeJourney;

import java.io.File;
import java.io.FileOutputStream;

public class Main {
    public static String TITLE = "* [%s](%s/README.md)\n";
    public static String FILE = " * [%s](%s/%s)\n";
    public static void main(String[] args) throws Exception {
        String path = "/Users/yuyunchen/tamp/CodeJourney/";
        FileOutputStream fos = new FileOutputStream(path + "SUMMARY.md", true);
        File file = new File(path);
        String[] lists = file.list();
        for (String list : lists) {
            String s = path + list;
            if (new File(s).isDirectory()
                    && !list.startsWith(".")
                    && !list.startsWith("node_modules")
                    && !list.startsWith("tools")
                    && !list.startsWith("_")
            ) {
                fos.write(String.format(TITLE, list, list).getBytes());
                File dir = new File(s);
                String[] dirFiles = dir.list();
                for (String f : dirFiles) {
                    if (f.startsWith("README")) {
                        continue;
                    }
                    String name = f.replace(".md", "");
                    fos.write(String.format(FILE, name, list, f).getBytes());
                }
            }
            fos.write("\n".getBytes());
        }
        fos.close();
    }
}
