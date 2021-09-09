import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;

public class CustomClassLoader extends URLClassLoader {
    
    public CustomClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    protected PermissionCollection getPermissions(CodeSource codesource) {
        //return new Permissions();
        return super.getPermissions(codesource);
    }
}
