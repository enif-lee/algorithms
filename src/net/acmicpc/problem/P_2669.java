package net.acmicpc.problem;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.acmicpc.problem.P_2669.Rectangle;


/**
 * @author Lee Jinseoung
 * @problem https://www.acmicpc.net/problem/2669
 *
 */
public class P_2669 {
	public static List<Rectangle> rectangles = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);

	
	public static void main(String[] args) {
		int N = sc.nextInt();
		
		for(int i = 1; i <= N ; i++ ){
			Rectangle newRect = new Rectangle(sc.nextInt(), sc.nextInt(), sc.nextInt());
			newRect.index=i;
			
			for(Rectangle rect : new ArrayList<Rectangle>(rectangles)) {
				Rectangle crossed = rect.getCrossedRectangle(newRect);
				if(crossed != null){
					rect.addCrossedRectangle(crossed);
					if(rect.getArea() == 0) {
						rectangles.remove(rect);
					}
				}
			}
			
			rectangles.add(newRect);
		}
		
		for(Rectangle rect : rectangles) {
			System.out.printf("%d : %d\n", rect.index, rect.getArea());
		}
	}

	
	public static class Rectangle {
		int index, x, y, width, height;

		private List<Rectangle> crossedArea = new ArrayList<>();

		public Rectangle(int x, int y, int length) {
			this.x = x;
			this.y = y;
			this.width = this.height = length;
		}

		public Rectangle(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		
		public boolean isCrossed (Rectangle target) {
			return target.x <  this.x + width && target.x + target.width > this.x &&
					target.y <  this.y + height && target.y + target.height > this.y;
		}

		public Rectangle getCrossedRectangle(Rectangle target) {
			if (!this.isCrossed(target)) return null;
		
			int	x = ( this.x < target.x ) ? target.x : this.x,
				y = ( this.y < target.y ) ? target.y : this.y,
				width = ( target.x + target.width < this.x + this.width ? target.x + target.width : this.x + this.width ) - x,
				height= ( target.y + target.height < this.y + this.height ? target.y + target.height : this.y + this.height ) - y;
			
			return new Rectangle ( x, y, width, height);
		}
		
		public void addCrossedRectangle (Rectangle cross) {
			for(Rectangle crossed : new ArrayList<Rectangle>(crossedArea)){
				Rectangle temp = crossed.getCrossedRectangle(cross);
				
				if(temp != null){
					crossed.addCrossedRectangle(temp);
					if(crossed.getArea() == 0) {
						this.crossedArea.remove(crossed);
					}
				}
			}
			crossedArea.add(cross);
		}
		
		public int getArea() {
			int crossArea = 0;
			for(Rectangle area : crossedArea) crossArea += area.getArea();
			return width*height - crossArea;
		}

	}

}