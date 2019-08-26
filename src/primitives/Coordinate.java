	package primitives;
	
	public class Coordinate {
		protected double _coordinate;
	
		
		// ***************** Constructors ********************** // 
    	public Coordinate() {this._coordinate=0.0;}
	
        public Coordinate(double _coordinate) {
				super();
			this._coordinate = _coordinate;
				}
    	public Coordinate(Coordinate coordinate){this._coordinate=coordinate._coordinate;}
			
    	// ***************** Getters/Setters ********************** // 
	    public double get_coordinate() {
			return _coordinate;
			}
	
		public void set_coordinate(double _coordinate) {
			this._coordinate = _coordinate;		}
		
		
		// ***************** Administration  ******************** // 

		
	
		@Override
		public String toString() {
			return "Coordinate [get_coordinate()=" + get_coordinate() + "]";
		}
	
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coordinate other = (Coordinate) obj;
			if (Double.doubleToLongBits(_coordinate) != Double.doubleToLongBits(other._coordinate))
				return false;
			return true;
		}
	
		public void add(Coordinate coordinate ){
			this._coordinate+=coordinate._coordinate;
		}
			
			
		public  void substract(Coordinate coordinate){
			this._coordinate-=coordinate._coordinate;
		
		}
		 
	}
