# lb4s

`lb4s` is a basic Scala client for the Letterboxd API.

## Usage

To get started, create an `UnauthorizedLetterboxdClient` using your credentials for the Letterboxd API.
If you want to use endpoints that require authorization, call `authorize` to get a client for the authenticated member.

```scala
val filmId = LBID("26j2")

val unauthorizedClient = new UnauthorizedLetterboxdClient("[API key]", "[API secret]")
val film = client.film(filmId)

val authorizedClient = unauthorizedClient.authorize("[username]", "[password]")
val filmRelationship = authorizedClient.filmRelationship(filmId)
```

## Testing

`lb4s.response` covers serialization for some API responses. `lb4s.client` has some end-to-end tests against the API.

Some specs in `lb4s.client` use the authorized client for read-only operations.
To successfully run these, create the `src/test/resources/api_credentials.json`
and populate the following values with your own credentials for the Letterboxd API:

```json
{
  "api_key":    "...",
  "api_secret": "...",
  "username":   "...",
  "password":   "..."
}
```

## License

`lb4s` is available under the GPLv3 — see [LICENSE.md](LICENSE.md) for details.
