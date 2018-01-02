@setlocal
call E:\Develop\Clojure\setenv.bat
set MIDJE_COLORIZE=true

call lein midje :autotest
