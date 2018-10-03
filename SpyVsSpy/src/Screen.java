import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen 
{
	public final int[] pixels;
	private BufferedImage bufferedImage;
	
	public Screen()
	{
		this.bufferedImage = new BufferedImage(CanvasManager.WIDTH, CanvasManager.HEIGHT, BufferedImage.TYPE_INT_RGB);
		this.pixels = ((DataBufferInt)this.bufferedImage.getRaster().getDataBuffer()).getData();
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(this.bufferedImage, 0, 0, null);
	}
	
	public void clear()
	{
		for(int i = 0; i < pixels.length; i++)
		{
			this.pixels[i] = 0x00;
		}
	}
}
