package ir.mahan.train.view;

public class EnumDefinitions 
{	
	
	public enum Category
	{
		TEACHER("Teacher"),
		STUDENT("Student"),
		STAFF("Staff");
		
		private String _name;
		private Category(String name)
		{
			_name = name;
		}
		
		@Override
		public String toString()
		{
			return this._name;
		}
	}
	
	public enum Age 
	{
	    FENCH ("18"),
	    YOUNG ("20-30"),
	    MIDDLE ("more");

	    private String _name;
		private Age(String name)
		{
			_name = name;
		}
		
		@Override
		public String toString()
		{
			return this._name;
		}			    
	}
	
	public enum Gender 
	{
		MALE("Male"),
		FEMALE("Female");
		
		private String _name;
		private Gender(String name)
		{
			_name = name;
		}
		
		@Override
		public String toString()
		{
			return this._name;
		}
	};
	
	public enum City 
	{
		TEHRAN("Tehran"),
		KERMAN("Kerman");
		
		private String _name;
		private City(String name)
		{
			_name = name;
		}
		
		@Override
		public String toString()
		{
			return this._name;
		}
				
	};
	
	public enum FavoritSport
	{
		FOOTBALL("Football"),
		VALIBALL("Valiball"),
		OTHER("Other");
		
		private String _name;
		private FavoritSport(String name)
		{
			_name = name;
		}
		
		@Override
		public String toString()
		{
			return this._name;
		}
	}

}
