package com.apptware.interview.singleton.SinglrtonTest2;

import java.lang.reflect.Constructor;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
public class SingletonTest {

	    @Test
	    void testSingletonInstance() {
	        // Get the first instance of the Singleton
	        Singleton instance1 = Singleton.getInstance();
	        
	        // Ensure that the instance is not null
	        Assertions.assertThat(instance1).isNotNull();
	        
	        // Get the second instance of the Singleton
	        Singleton instance2 = Singleton.getInstance();
	        
	        // Assert that both instances are the same
	        Assertions.assertThat(instance1).isSameAs(instance2);
	    }

	    @Test
	    @SneakyThrows
	    void testSingletonReflection() {
	        // Get the first instance of the Singleton
	        Singleton instance1 = Singleton.getInstance();

	        // Use reflection to attempt to create a second instance
	        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
	        constructor.setAccessible(true);

	        // Expect an exception to be thrown when trying to create another instance
	        Assertions.assertThatThrownBy(() -> constructor.newInstance())
	                  .isInstanceOf(IllegalStateException.class)
	                  .hasMessageContaining("Cannot create another instance of Singleton using reflection");
	        
	        // Ensure the first instance is still the same
	        Assertions.assertThat(instance1).isSameAs(Singleton.getInstance());
	    }
	}
