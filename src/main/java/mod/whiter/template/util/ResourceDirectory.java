package mod.whiter.template.util;

import mod.whiter.template.App;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ResourceDirectory {
    public static void main(String dir) throws IOException {
        URL url = App.class.getClassLoader().getResource(dir + "/");
        assert url != null;
        String jarPath = url.toString().substring(0, url.toString().indexOf("!/") + 2);

        URL jarURL = new URL(jarPath);
        JarURLConnection jarCon = (JarURLConnection) jarURL.openConnection();
        JarFile jarFile = jarCon.getJarFile();
        Enumeration<JarEntry> jarEntrys = jarFile.entries();

        while (jarEntrys.hasMoreElements()) {
            JarEntry entry = jarEntrys.nextElement();
            String name = entry.getName();

            if (name.startsWith(dir + "/") && !entry.isDirectory()) {
                System.out.println(App.class.getClassLoader().getResourceAsStream(name));
//                doWithInputStream(App.class.getClassLoader().getResourceAsStream(name));
            }
        }

    }
}
