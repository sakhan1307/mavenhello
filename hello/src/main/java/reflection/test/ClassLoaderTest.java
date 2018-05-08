package reflection.test;

import java.io.*;

class CommandClassLoader extends ClassLoader{
	
	public Class<?> findClass(String name) throws ClassNotFoundException{
		String path = "commands/" + name + ".class";
		try{
			FileInputStream in = new FileInputStream(path);
			byte[] code = new byte[in.available()];
			in.read(code);
			in.close();
			return defineClass(name, code, 0, code.length);
		}catch(IOException e){
			throw new ClassNotFoundException(name);
		}
	}
}

class CommandSecurityManager extends SecurityManager{

	public void checkPermission(java.security.Permission perm){
		if((perm instanceof RuntimePermission) && perm.getName().equals("exitVM"))
			super.checkPermission(perm);
	}
}

class ClassLoaderTest{

	public static void main(String[] args) throws Exception{
		BufferedReader console = new BufferedReader(
					new InputStreamReader(System.in));
		if(System.getSecurityManager() == null)
			System.setSecurityManager(new CommandSecurityManager());
		for(;;){
			System.out.print("CLT>");
			String cmd = console.readLine();
			if(cmd.equals("quit")) break;
			try{
				ClassLoader loader = new CommandClassLoader();
				Class<?> c = loader.loadClass(cmd);
				Runnable r = (Runnable) c.newInstance();
				r.run();
			}catch(Exception e){
				System.out.println("ERROR : " + e);
			}
			System.out.println();
		}
	}
}





