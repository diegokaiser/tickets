'use strict';

const gulp = require('gulp');
const sass = require('gulp-sass');
const autoprefixer = require('gulp-autoprefixer')

sass.compiler = require('node-sass');

gulp.task('sass', () => {
    return gulp.src('./sass/**/*.scss')
        .pipe(sass())
        .pipe(autoprefixer({
            browsers: [
                "last 2 versions",
                "ie 8",
                "ie 9",
                "> 1%",
                "Firefox >= 20",
                "Opera 12.1",
                "iOS 7"
            ],
            cascade: false
        }))
        .pipe(gulp.dest('./css'));
});