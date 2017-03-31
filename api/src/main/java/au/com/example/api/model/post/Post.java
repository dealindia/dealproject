package au.com.example.api.model.post;

public class Post {
	
	 private Long id;
		private String firstName;
		private String lastName;

	    public Post() {
	        this(null, null, null);
	    }
		
		public Post(Long id, String firstName, String lastName) {
	        this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }
		
		public String getFirstName() {
			return firstName;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

}
