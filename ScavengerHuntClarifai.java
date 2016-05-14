	public boolean foundItem (File directory, Tag target) {
		ClarifaiClient clarifai = new ClarifaiClient(CLIENT_ID, CLIENT_SECRET);
		
		List<RecognitionResult> results =
		    clarifai.recognize(new RecognitionRequest(directory));
	
		for (Tag tag : results.get(0).getTags()) {
		  if (tag.equals(target))
			  return true;
		}
		
		return false;
	}
