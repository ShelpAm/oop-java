$java = "java"
$javac = "javac"
$prefixDir = "./src/main/java/"
$src = Get-ChildItem -Path $prefixDir -Filter *.java -Recurse

if ($args.Count -ne 1) {
  Write-Host "Usage: build-and-run.ps1 week<week-number>"
  exit 1
}

try {
  & $javac -Xlint:unchecked -d bin $src
} catch {
  Write-Host "Compilation failed. Running is stopped."
  exit 1
}

& $java -enableassertions --class-path bin shelpam.$args[0].Main
