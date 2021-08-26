# Sorting and Filtering Validation

This project aims to go into SimpleSite, apply sorting, filtering and validate the data.

Testcases are written by considering below points:

1. Filtering applies on 'Name' & 'Complexity' columns. So, validated filtered data based on these two columns.
2. For the sorting part, two fields are considered ('Name' & 'Average Impact') out of 4, and validated the data based on them.

Steps:

1. Go to https://mystifying-beaver-ee03b5.netlify.app/ .

2. Click on the Sort Data drop down and select by Name and then Impact score.

3. Enter data provided in the config file into the Filter Data text box. (can give the data as per the need in the config file present under 'ConfigReader' folder.)

4. Validate the sorting and filtering functionality.

## Pre-requisite

For setup, read and follow the below instructions:

1. Install GIT (https://git-scm.com/downloads)
2. Install JDK (https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html)
3. Install Eclipse (https://www.eclipse.org/downloads/packages/release/neon/3/eclipse-ide-java-ee-developers)
	
## Quickstart

1. Open a Git Bash Prompt and run below command:
   `git clone https://github.com/Ishita2015/Sorting_and_Filtering_Validation.git`

2. Open Eclipse:
	1. Import Project as Maven -> Existing Maven Projects
	2. Select `SortingAndFiltering` project folder and click finish.

3. The project will be imported and there is nothing special to do.

4. Now, you can run the `testng.xml` as a TestNG suite and it validates the sorting and filtering functionality.
