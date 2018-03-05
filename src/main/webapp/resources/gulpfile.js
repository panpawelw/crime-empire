var gulp = require('gulp');
var sass = require('gulp-sass');
// var jshint = require('gulp-jshint');
var sourcemaps = require('gulp-sourcemaps');

gulp.task('sass', function() {
    return gulp.src('scss/main.scss')
        .pipe(sourcemaps.init())
        .pipe(sass({
            errLogToConsole: true,
            outputStyle: 'expanded'
        }))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest('css'))
});

// gulp.task('gulp-jshint', function () {
//   return gulp.src('./*.js')
//     .pipe(jshint())
//     .pipe(jshint.reporter('default'));
// });

gulp.task('watch', function(){
    gulp.watch('scss/*.scss', ['sass']);
});

// gulp.task('watch', function () {
// gulp.watch('./*.js', ['gulp-jshint']);
// });
