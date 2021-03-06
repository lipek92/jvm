package com.lipek;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class JavassistSimpleTransformer implements ClassFileTransformer {

	public byte[] transform(ClassLoader loader, String className,
			Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
			byte[] bytes) throws IllegalClassFormatException {

		byte[] result = bytes;

		if (className.contains("MyClass") || className.contains("MyClass2")) {
			try {
				String dotClassName = className.replace('/', '.');

				ClassPool cp = ClassPool.getDefault();
				CtClass ctClazz = cp.get(dotClassName);
				
				CtMethod method1 = ctClazz.getDeclaredMethod("doSomething");
				
				method1.addLocalVariable("elapsedTime", CtClass.longType);

				method1.insertBefore("elapsedTime = System.currentTimeMillis();");
				method1.insertAfter(" { elapsedTime = System.currentTimeMillis() - elapsedTime; "
				+ "System.out.println(\" Method elapsedTime = \" + elapsedTime);}");
				result = ctClazz.toBytecode();
			}

			catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
