/**
 * 
 */
package unitests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
import renderer.ImageWriter;

/**
 * test of Image Writer
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */
public class ImageWriterTest {
	/**
	 * Test method for
	 * {@link renderer.ImageWriter#writePixel(int, int, primitives.Color)}.
	 */
	@Test
	public void testWritePixel() {
		// Create a basic image.
		
		ImageWriter imageWriter = new ImageWriter("ImageBasic", 500, 800);
		int nx = imageWriter.getNx();
		int ny = imageWriter.getNy();
		for (int i = 0; i < nx; i++) {
			for (int j = 0; j < ny; j++) {
				if (i % 50 == 0 || j % 50 == 0) {
					imageWriter.writePixel(i, j, primitives.Color.GREEN);
				} else {
					imageWriter.writePixel(i, j, primitives.Color.RED);
				}
			}
		}
		imageWriter.writeToImage();
	}
}
