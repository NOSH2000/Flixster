# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

📝 `NOTE - PASTE PART 2 SNIPPET HERE:` Paste the README template for part 2 of this assignment here at the top. This will show a history of your development process, which users stories you completed and how your app looked and functioned at each step.

---

## Flix Part 1

### User Stories

#### REQUIRED (10pts)
- [x] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [x] (2pts) Views should be responsive for both landscape/portrait mode.
   - [x] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [x] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [x] (2pts) Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading. Followed a glide tutorial by [Android Coding](https://www.youtube.com/watch?v=wpJ84R8-0RY&ab_channel=AndroidCoding).

- [x] (2pts) Improved the user interface by experimenting with styling and coloring.

- [ ] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF
<img src='Flixster.gif' title='Flixster App Walkthrough' width='' alt='Flixster App Walkthrough' width=250><br>

GIF created with [IMG2GO](https://www.img2go.com/convert-video-to-gif).

### Notes
Describe any challenges encountered while building the app.
- I had difficulty running the app on Android Studio the first couple of times. I did not realize that we were not supposed to check the android.support libries option.
- I changed the text font to ```serif```. However, while the change reflected on the emulator, it did not show on OnePlus device.
- I added an app icon but it is blurry and not what I wanted it to look like.

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
