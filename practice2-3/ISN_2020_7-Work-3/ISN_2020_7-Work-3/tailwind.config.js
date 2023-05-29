/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js}"],
  theme: {
    container: {
      center: true
    },
    extend: {},
    screens: {
      'xl': '1280px',
      'lg': '1024px',
      'md': '768px',
      'sm': '375px'
    }
  },
  plugins: [],
}
