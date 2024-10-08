package com.apptware.interview.singleton.SinglrtonTest2;

import java.lang.reflect.Constructor;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
public class SingletonTest {

	    @Test
	    @SneakyThrows
	    void testSingleton() {
	        // Get the first instance of the Singleton
	        SingletonTest instance1 = SingletonTest.getInstance();

	        // Use reflection to attempt to create a second instance
	        Constructor<SingletonTest> constructor = SingletonTest.class.getDeclaredConstructor();
	        constructor.setAccessible(true);

	        // Expect an exception to be thrown when trying to create another instance
	        Assertions.assertThatThrownBy(() -> constructor.newInstance())
	                  .isInstanceOf(IllegalStateException.class)
	                  .hasMessageContaining("Cannot create another instance of Singleton using reflection");

	        // Ensure the first instance is still the same
	        Assertions.assertThat(instance1).isSameAs(SingletonTest.getInstance());
	    }

		private static SingletonTest getInstance() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	



