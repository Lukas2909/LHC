package infrastructure.lhc;

import infrastructure.Configuration;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ComponentLoader {

    private Class clazz;
    private Object instance;
    private Object port;

    private void loadClazzFromJavaArchive() {
        try {
            URL[] urls = {new File(Configuration.instance.subFolderPathOfJavaArchive).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls,ComponentLoader.class.getClassLoader());
            clazz = Class.forName(Configuration.instance.nameOfClass,true,urlClassLoader);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void provideInstanceOfClass() {
        try {
            instance = clazz.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }

    private void provideComponentPort() {
        try {
            port = clazz.getDeclaredField("port").get(instance);
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int executeSearchMethod(String text, String pattern){
        loadClazzFromJavaArchive();
        provideInstanceOfClass();
        provideComponentPort();
        try {
            Method method = port.getClass().getMethod("search", String.class, String.class);
            int result = (int)method.invoke(port, text, pattern);
            return result;
            }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
