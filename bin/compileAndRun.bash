# Start from the root directory.

# Redirect compiled files to classes folder, remember to add it to gitignore.
# "find" command finds all java files inside src directory (including subpackages).
javac -d src/classes $(find src -name "*.java")

# Since the Runner class is inside a package, remember to include it.
java -cp src/classes Runner
