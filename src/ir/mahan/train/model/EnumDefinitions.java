package ir.mahan.train.model;

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

	public enum City 
	{
		Tehran,
		Kerman;		
	};
	
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
		
		public static Age getValue(String name)
		{
			switch (name) 
			{
				case "18":
					return Age.valueOf("FENCH");
				case "20-30":
					return Age.valueOf("YOUNG");
				case "more":
					return Age.valueOf("MIDDLE");
				default:
					return null;
			}
		}
	}

}
