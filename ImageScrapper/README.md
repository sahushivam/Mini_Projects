<h1>Image Scrapper from a url</h1>
<h3>Flags used in commands</h3>
-nd prevents the creation of a directory hierarchy (i.e. no directories).

-r enables recursive retrieval. See Recursive Download for more information.

-P sets the directory prefix where all files and directories are saved to.

-A sets a whitelist for retrieving only certain file types.

-r -l 1: recursive level 1

-e robots=off: execute command robotos=off as if it was part of .wgetrc file. This turns off the robot exclusion which means you ignore robots.txt and the robot meta tags (you should know the implications this comes with, take care).

Make the scraper.sh shell script executable: chmod +x scraper.sh
