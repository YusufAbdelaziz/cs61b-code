# Start from the root directory.

# Redirect compiled files to classes folder, remember to add it to gitignore.
# "find" command finds all java files inside src directory (including subpackages).
echo "Compiling..."
javac -d classes $(find src -name "*.java")
PS3="Select an option: "
# find command returns a single string with all the file paths separated by a space.
file_paths_single_string=$(find src -name "Runner*")
file_paths=()
# Split the single string into an array of file paths.
for path in $file_paths_single_string; do
  file_paths+=("$path")
done
# Get the length of the array.
file_paths_length=${#file_paths[@]}

select choice in "${file_paths[@]}"; do
  case $REPLY in
  *)
    # Check if the user input is a valid option and within the range of the array.
    if [ $REPLY -gt $file_paths_length ]; then
      echo "Invalid option. Please choose a number from 1 to $file_paths_length."
      exit 1
    fi
    # Replace all forward slashes with dots. src/graphTraversalAlgos/Runner.java -> src.graphTraversalAlgos.Runner.java
    replaced_string=${choice//\//.}
    # The % operator is used for pattern matching and removes the longest
    # match of the pattern ".java" from the end of the string.
    removed_extension=${replaced_string%.java}
    # The # operator is used for pattern matching and removes the shortest
    # match of the pattern "src." from the beginning of the string.
    removed_prefix=${removed_extension#src.}
    # Run the java file selected and its full path.
    echo "Running ${file_paths[$REPLY]}"
    java -cp classes $removed_prefix

    break
    ;;
  esac
done
