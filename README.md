# jpg-raf-organizer
## Description
I usually don't post-process my photos (from Fujifilm camera). I just browse JPGs and delete not interesting positions,
but I want to keep all RAF files (in some organized way). This program just moves all RAFs without corresponding JPGs to
newly created folder inside current directory.

## Usage
1. In `Main.java` set `path` variable to absolute path of your photos directory
2. In `Main.java` set `rafsDirectoryName` variable to name of your target RAFs directory
3. Run program

## Alghoritm
1. Read all files in directory
2. Organize files into two sets - JPGs and RAFs
3. Iterate over JPG and store File reference to corresponding RAF file in set
5. Move all another RAF files into new folder (if folder does not exist - create it)
