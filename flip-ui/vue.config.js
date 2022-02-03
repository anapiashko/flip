const process = require(".eslintrc");
module.exports = {
  devServer: {
    host: 'localhost',
    port: process.env.PORT || 8080,
  }
};
