package englard.compiler;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Test;

public class CompileTest {

	@Test
	public void testGetHexCommand() throws IOException {
		String input = "LD 64\nDEC \nBZ 59\nST 64\nLD 66\nSWP\nLD 255\nADD\nST 255\nLD 65\n"
				+ "ADD\nSWP\nLD 254\nADD\nST 254\nLD 12\nSWP\nLD 66\nADD\nST 66\nLD 00\nADD\nSWP"
				+ "\nLD 65\nADD\nST 65\nBR 00\nSTP\nDATA 0000F03000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001 0000F03000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";
		InputStream stream = System.in;
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		BufferedReader read = new BufferedReader(new InputStreamReader(
				System.in));
		Compiler c = new Compiler(read);

		Assert.assertEquals(
				"040563B14004220FF31FF041320FE31FE00C2042314200032041314170080000F03000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"
						.toLowerCase(), c.getHexCommnad().toLowerCase());

	}
}
