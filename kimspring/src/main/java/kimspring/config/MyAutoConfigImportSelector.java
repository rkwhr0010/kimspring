package kimspring.config;

import java.util.stream.StreamSupport;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector{
	private final ClassLoader classLoader;
	
	public MyAutoConfigImportSelector(ClassLoader classLoader) {
		super();
		this.classLoader = classLoader;
	}
	
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		ImportCandidates load = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
		return StreamSupport
				.stream(load.spliterator(), false)
				.toArray(String[]::new);
	}
}
