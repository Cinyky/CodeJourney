package org.cyy.CodeJourney;

import java.io.File;
import java.io.FileOutputStream;

public class Main {
    public static String FILE = " * [%s](%s/%s)\n";public static void main(String[] args) throws Exception {
        String path = "/Users/yuyunchen/tamp/CodeJourney/";
        writeReadme(path);
    }
    private static void writeReadme(String path) throws Exception {
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
                File t = new File(s + "/" + "README.md");
                if (!t.exists()) {
                    t.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(t);
                fos.write(("# " + list + "\n").getBytes());
                String[] files = new File(s).list();
                for (String f : files) {
                    if (f.startsWith("README")) {
                        continue;
                    }
                    fos.write(String.format("* [%s](%s) \n", f.replace(".md", ""), f).getBytes());
                }
                fos.close();
            }
        }
    }
}
