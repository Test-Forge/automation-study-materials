# Front-End Unit Test Workshop - Fixers

### A. Error: Jest encountered an unexpected token
Configure jest to compile ts files.

<details>
<summary>Solution</summary>

- install **babel/preset-env**:
- install **babel/preset-react**
- install **babel/preset-typescript**
```shell
npm install -D @babel/preset-env
npm install -D @babel/preset-react
npm install -D @babel/preset-typescript
```
- add file **babel-jest.config.js** to project
```js
module.exports = {
  presets: ['@babel/preset-env', '@babel/preset-react']
}
```
- add file **babel.config.js** to project
```js
module.exports = {
  presets: [['@babel/preset-env', { targets: { node: 'current' } }],
    ["@babel/preset-react", {"runtime": "automatic"}]],
}
```
</details>

### B'. Error: Test environment jest-environment-jsdom cannot be found
Install missing library.

<details>
<summary>Solution</summary>

- install **jest-environment-jsdom**:
```shell
npm install -D jest-environment-jsdom
```
</details>

### B". Error: Document is not defined
Configure jest to use jsdom.

<details>
<summary>Solution</summary>

- Add `testEnvironment: 'jsdom'` to **jest.config.js**:
```js
module.exports = {
   testEnvironment: 'jsdom'
}
```
</details>

### C. Error: Cannot find module '@/modules'
Resolve module path in Jest config

<details>
<summary>Solution</summary>

- Add `roots: ['src', 'test']` to **jest.config.js**:
- Add `moduleDirectories: ['node_modules', __dirname]` to **jest.config.js**:
- Add `moduleNameMapper: {'^@/(.*)$': '<rootDir>/src/$1'}` to **jest.config.js**:
```js
module.exports = {
   testEnvironment: 'jsdom',
   roots: ['src', 'test'],
   moduleDirectories: ['node_modules', __dirname],
   moduleNameMapper: {
      '^@/(.*)$': '<rootDir>/src/$1',
   }
}
```
</details>

### D. Error: Jest encountered an unexpected token
Install babel plugins and configure in Jest config

<details>
<summary>Solution</summary>

- Install **babel/plugin-transform-runtime**:
- Install **babel-plugin-transform-vite-meta-env**:
- Add `plugins: ['@babel/transform-runtime', 'babel-plugin-transform-vite-meta-env']` to **babel-jest.config.js**
```js
module.exports = {
  presets: ['@babel/preset-env', '@babel/preset-react'],
  plugins: ['@babel/transform-runtime', 'babel-plugin-transform-vite-meta-env'],
}
```
- Add `transform: {
  "^.+\\.(js|jsx)$": ['babel-jest', { configFile: './babel-jest.config.js' }],
  }` to **jest.config.js**:
```js
module.exports = {
   testEnvironment: 'jsdom',
   roots: ['src', 'test'],
   moduleDirectories: ['node_modules', __dirname],
   moduleNameMapper: {
      '^@/(.*)$': '<rootDir>/src/$1',
   },
    transform: {
        "^.+\\.(js|jsx)$": ['babel-jest', { configFile: './babel-jest.config.js' }],
    }
}
```
</details>

### E. Error: React is not defined
Define React as global module

<details>
<summary>Solution</summary>

- Install **@testing-library/jest-dom**
```shell
npm install -D @testing-library/jest-dom
```
- Create `SetupJest.js` file under `/frontend/test/` directory and add:
```js
import '@testing-library/jest-dom';
import React from 'react';
global.React = React;
```
- Add `setupFilesAfterEnv: ['<rootDir>/test/SetupJest.js']` to **jest.config.js**
```js
module.exports = {
  testEnvironment: 'jsdom',
  roots: ['src', 'test'],
  moduleDirectories: ['node_modules', __dirname],
  moduleNameMapper: {
    '^@/(.*)$': '<rootDir>/src/$1',
  },
  transform: {
    "^.+\\.(js|jsx)$": ['babel-jest', { configFile: './babel-jest.config.js' }],
  },
  setupFilesAfterEnv: ['<rootDir>/test/SetupJest.js']
}
```
</details>

### F. Error: Uncaught [Error: Element type is invalid: expected a string (for built-in components) or a class/function
Wrong import declaration

<details>
<summary>Solution</summary>

- In file `test/pages/Customer/index.test.js` change
```js
import {Customer} from '../../../src/pages/Customer/index'
```
To
```js
import Customer from '../../../src/pages/Customer/index'
```
</details>

### G. Error: Could not find react-redux context value; please ensure the component is wrapped in a <Provider>
Create a test wrapper and wrap tested component.

<details>
<summary>Solution</summary>

- Install redux-mock-store
```shell
npm install -D redux-mock-store
```
- Create `TestRender.js` file under `/frontend/test/` directory and create test renderer:
```js
import {render} from '@testing-library/react'
import {Provider} from "react-redux";
import configureStore from 'redux-mock-store'

const state = {};
const mockStore = configureStore();
let store;

const providers = ({children}) => {
  store = mockStore(state)
  return (
          <Provider store={store}>
              {children}
          </Provider>
  )
}

const testRender = (ui, options) => render(ui, {wrapper: providers, ...options})
export {testRender}
```
- In your tests render tested component with  wrapped `testRender`
```js
testRender(<Customer />)
```
</details>

### H. Error: Cannot read properties of undefined (reading 'result') in redux\translate\selector
Add required props to store state

<details>
<summary>Solution</summary>

- In `TestRender.js` file add `translate: {result: 'ENG', langCode: 'ENG'}` to `const state`
```js
import {render} from '@testing-library/react'
import {Provider} from "react-redux";
import configureStore from 'redux-mock-store'

const state = {
  translate: {result: 'ENG', langCode: 'ENG'}
};
const mockStore = configureStore();
let store;

const providers = ({children}) => {
  store = mockStore(state)
  return (
          <Provider store={store}>
              {children}
          </Provider>
  )
}

const testRender = (ui, options) => render(ui, {wrapper: providers, ...options})
export {testRender}
```
</details>

### I. Error: useAppContext must be used within a AppContextProvider
Wrap tested component with AppContext

<details>
<summary>Solution</summary>

- In `TestRender.js` file import `AppContextProvider`
```js
import {AppContextProvider} from '@/context/appContext';
```
- Wrap tested component with `AppContextProvider`
```js
import {render} from '@testing-library/react'
import {Provider} from "react-redux";
import configureStore from 'redux-mock-store'
import {AppContextProvider} from '@/context/appContext';

const state = {
  translate: {result: 'ENG', langCode: 'ENG'}
};
const mockStore = configureStore();
let store;

const providers = ({children}) => {
  store = mockStore(state)
  return (
          <Provider store={store}>
            <AppContextProvider>
              {children}
            </AppContextProvider>
          </Provider>
  )
}

const testRender = (ui, options) => render(ui, {wrapper: providers, ...options})
export {testRender}
```
</details>

### J. Multiple Errors: Cannot read properties of undefined (reading '****')
Add required props to store state

<details>
<summary>Solution</summary>

- In `TestRender.js` file add expected props and values to `const state`
```js
const state = {
  translate: {result: 'ENG', langCode: 'ENG'},
  crud: {
    list: {
      isLoading: false,
      result: {
        items: [],
        pagination: {
          current: 0,
          pageSize: 0
        }
      }
    },
    delete: {
      isSuccess: true,
      isLoading: false,
      current: {
        _id: 1
      }
    }
  }
};
```
</details>

### K. Error: ResizeObserver is not defined
Provide a ResizeObserver object to Jest context

<details>
<summary>Solution</summary>

- Install **resize-observer-polyfill**
```shell
npm install -D resize-observer-polyfill
```
- In `SetupJest.js` add `global.ResizeObserver = require('resize-observer-polyfill')`
```js
import {jest} from '@jest/globals';
import '@testing-library/jest-dom';
import React from 'react';

global.React = React;
global.ResizeObserver = require('resize-observer-polyfill')
```
</details>

### L. Error: Actions must be plain objects. Use custom middleware for async actions.
Provide a middleware to redux store mock

<details>
<summary>Solution</summary>

- In `TestRender.js` import and pass `thunk` as param to `configureStore()` function
```js
import {render} from '@testing-library/react'
import {Provider} from "react-redux";
import configureStore from 'redux-mock-store'
import {AppContextProvider} from '@/context/appContext';
import thunk from'redux-thunk'

const state = {
    translate: {result: 'ENG', langCode: 'ENG'},
    crud: {
        list: {
            isLoading: false,
            result: {
                items: [],
                pagination: {
                    current: 0,
                    pageSize: 0
                }
            }
        },
        delete: {
            isSuccess: true,
            isLoading: false,
            current: {
                _id: 1
            }
        }
    }
};

const middleware = [thunk]
const mockStore = configureStore(middleware);
let store;

const providers = ({children}) => {
    store = mockStore(state)
    return (
        <Provider store={store}>
            <AppContextProvider>
                {children}
            </AppContextProvider>
        </Provider>
    )
}

const testRender = (ui, options) => render(ui, {wrapper: providers, ...options})

export {testRender}
```
</details>

### M. Error: window.matchMedia is not a function
Know Jest issue for React apps

<details>
<summary>Solution</summary>

- Mock `matchMedia` in `SetupJest.js` file
```js
import {jest} from '@jest/globals';
import '@testing-library/jest-dom';
import React from 'react';

global.React = React;
global.ResizeObserver = require('resize-observer-polyfill')

Object.defineProperty(window, 'matchMedia', {
    writable: true,
    value: jest.fn().mockImplementation(query => ({
        matches: false,
        media: query,
        onchange: null,
        addListener: jest.fn(),
        removeListener: jest.fn(),
        addEventListener: jest.fn(),
        removeEventListener: jest.fn(),
        dispatchEvent: jest.fn(),
    })),
});
```
</details>