import java.io.IOException;

public class RpiRunner {
	
	public void initialize(int numP){
		try {
			Runtime.getRuntime().exec("python /home/pi/RPI_master.py 1 "+numP);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void move(int id, int s){
		try {
			Runtime.getRuntime().exec("python /home/pi/RPI_master.py 2 "+id+" "+s);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void win(int id){
		try {
			Runtime.getRuntime().exec("python /home/pi/RPI_master.py 3 "+id);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void reset(){
		try {
			Runtime.getRuntime().exec("python /home/pi/RPI_master.py 4");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
/*
There are four commands that can be called:
	Num Players: "1"; expects one argument; number of players (Ex. python RPI_master.py 1 4)
	Move Player: "2"; expects two arguments; player number, new position (Ex. python RPI_master.py 2 2 4)
	Set Winner:  "3"; expects one argument; winning player (Ex. python RPI_master.py 3 2)
	Reset Board: "4"; expects no argument;  (Ex. python RPI_master.py 4)
*/