/**
 * 
 */
package unitests;

import static primitives.Color.*;

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
		
		ImageWriter imageWriter = new ImageWriter("ImageBasic", 800, 500);
		int nx = imageWriter.getNx();
		int ny = imageWriter.getNy();
		for (int i = 0; i < ny; i++) {
			for (int j = 0; j < nx; j++) {
				if (i % 50 == 0 || j % 50 == 0) {
					imageWriter.writePixel(j, i, GREEN);
				} else {
					imageWriter.writePixel(j, i, RED);
				}
			}
		}
		imageWriter.writeToImage();
	}
}
