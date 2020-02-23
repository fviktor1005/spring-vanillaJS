const URL = "http://localhost:8080/meals/";

const searchString = document.getElementById("search-string");
const resultContainer = document.getElementById("results");
const searchPopup = document.getElementById("search-popup");
const searchCardsContainer = document.getElementById(
  "search-result-cards-container"
);

const debounce = (func, delay) => {
  let inDebounce;
  return function() {
    const context = this;
    const args = arguments;
    clearTimeout(inDebounce);
    inDebounce = setTimeout(() => func.apply(context, args), delay);
  };
};

const renderCard = meal => `
    <div class="card">
        <img src="${meal.strMealThumb}" />
        <hr />
        <div class="card_title">${meal.strArea}</div>
        <div class="card_description">${meal.strMeal}</div>
    </div>
`;

function onInput(event) {
  event.preventDefault();
  const { value } = event.target;
  if (value.trim()) {
    axios.get(`${URL}${value}`).then(({ data }) => {
      if (data) {
        searchPopup.style.visibility = "visible";

        resultContainer.innerHTML = data.reduce(
          (acc, meal) => `${acc}<li>${meal.strMeal}</li>`,
          ""
        );

        searchCardsContainer.innerHTML = data
          .slice(0, 6)
          .reduce((acc, meal) => `${acc}${renderCard(meal)}`, "");
      } else {
        searchPopup.style.visibility = "hidden";
      }
    });
  } else {
    searchPopup.style.visibility = "hidden";
  }
}

document.addEventListener("input", debounce(onInput, 500));
