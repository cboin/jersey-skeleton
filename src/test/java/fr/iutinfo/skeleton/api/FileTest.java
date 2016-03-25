package fr.iutinfo.skeleton.api;

import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static org.hamcrest.core.IsNull.notNullValue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileTest {

	private BufferedReader in = null;

	@Before
	public void setup() throws IOException {
		String ressourceName = "db.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		in = new BufferedReader(
				new InputStreamReader(loader.getResourceAsStream(ressourceName)));
	}

	@After
	public void teardown() throws IOException {
		if (in != null) {
			in.close();
		}

		in = null;
	}

	@Test
	public void test() throws IOException {
		String line = in.readLine();

       assertThat(line, notNullValue());
	}

}
