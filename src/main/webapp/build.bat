# npm install react --save
# npm install react react-dom
# npm install fixed-data-table --save
# npm install --save-dev babel-preset-react
# npm install babel-preset-es2015 --save --no-bin-links
# npm install jquery

cd src\main\webapp
browserify -t [ babelify --presets [ react ] ] main.js -o bundle.js

cd ..\..\..
mvn package


