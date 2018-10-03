import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class RenderEngine 
{
	private Screen screen;
	private BufferStrategy bufferStrategy;
	
	public RenderEngine(BufferStrategy bufferStrategy)
	{
		this.bufferStrategy = bufferStrategy;
		this.screen = new Screen();
	}
	
	public void render()
	{
		//Clear
		Graphics g = this.bufferStrategy.getDrawGraphics();
		this.screen.clear();
		//
		
		//Render
		
		
		//Draw
		this.screen.draw(g);
		//
		
		
		//Show
		this.bufferStrategy.show();
		g.dispose();
		//
	}
}
