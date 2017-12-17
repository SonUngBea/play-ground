var path = require( 'path' );
module.exports = {
  entry: './src/index.js',

  output: {
    // path: __dirname + '/public/',
    path: path.resolve('..', 'play-ground-web', 'src', 'main', 'webapp', 'resources', 'bundle'),
    filename: 'calendar.js'
  },

  devServer: {
    inline: true,
    port: 7777,
    contentBase: __dirname + '/public/'
  },

  module: {
    loaders: [
      {
        test: /\.js$/,
        loader: 'babel-loader',
        exclude: /node_modules/,
        query: {
          cacheDirectory: true,
          presets: ['es2015', 'react']
        }
      }
    ]
  }
};